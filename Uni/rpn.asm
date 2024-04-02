.data
.text
main:
	# Initialze registers to be used for specific purpose
	li 	$s0, 0					# $s0 will store the operand
	li 	$s1, 0					# $s1 will store the operator
	li 	$s2, 0					# $s2 will store the last character read
	li 	$s3, 0					# $s3 will store the character just read
	move 	$fp, $sp					# Save stack pointer
inputloop:	
	# Handle Keyboard Input using MMIO 
	lui  	$t0, 0xffff  				# $t0  = 0xffff0000
    	lw 	$t1, 0($t0)				# Get the control word
	andi 	$t1, $t1, 0x0001				# Get the status
	beq 	$t1, $0, inputloop			# Check if there is an input available, if not wait
	# Process input					
	move 	$s2, $s3					# Save the last character read
	lw 	$s3, 4($t0)				# Get the input character
	beq	$s3, ' ', space				# Check if its a space
	beq 	$s3, '+', add				# Check if its a '+'
	beq 	$s3, '-', subtract			# Check if its a '-'
	beq 	$s3, '*', multiply			# Check if its a '*'
	beq 	$s3, '/', divide				# Check if its a '/'
	beq 	$s3, ';', endofstatement			# Check if its a ';'
	blt 	$s3, '0', inputloop			# Check if its an invalid character
	bgt 	$s3, '9', inputloop			# Check if its an invalid character	
	# Process digit
	subi 	$t1, $s3, 48				# Convert ASCII digit to decimal equivalent
	mul 	$s0, $s0, 10				# Multiply the already accumulated number in $s0 by 10
	add 	$s0, $s0, $t1				# Accumulate this new digit in $s0
	j 	inputloop				# Wait for the new input
space:
	beq 	$s1, '*', domultiplication		# If the last operation was '*', do multiplication
	beq 	$s1, 'p', takepower			# If the last operation was 'p', take power
	beq 	$s2, ' ', inputloop			# If the last read character was also space, ignore this repeated space
	beq 	$s2, ';', inputloop			# If the last read character was a semicolon, ignore this space 
	blt 	$s2, '0', inputloop			# Check if the last character was a digit, if not ignore
	bgt 	$s2, '9', inputloop			# Check if the last character was a digit, if not ignore
	addi 	$sp, $sp, -4				# Make space in stack
	sw 	$s0, ($sp)				# Store the operand in the stack
	li 	$s0, 0					# Reset $s0 to 0
	j 	inputloop				# Wait for the new input
add:
	lw 	$t1, ($sp)				# Get the second operand from the stack
	addi 	$sp, $sp, 4				# Free up the space in stack
	lw 	$t0, ($sp)				# Get the first operand from the stack
	addi 	$sp, $sp, 4				# Free up the space in stack	 
	add 	$t0, $t0, $t1				# Add both the operands
	addi 	$sp, $sp, -4				# Make space in stack
	sw 	$t0, ($sp)				# Store the result back in the stack
	j 	inputloop				# Wait for the new input
subtract:
	lw 	$t1, ($sp)				# Get the second operand from the stack
	addi 	$sp, $sp, 4				# Free up the space in stack
	lw 	$t0, ($sp)				# Get the first operand from the stack
	addi 	$sp, $sp, 4				# Free up the space in stack	 
	sub 	$t0, $t0, $t1				# Subtract both the operands
	addi 	$sp, $sp, -4				# Make space in stack
	sw 	$t0, ($sp)				# Store the result back in the stack
	j 	inputloop				# Wait for the new input
multiply:
	beq 	$s2, '*', power				# If the last read character was also '*', this means the operator is power
	li 	$s1, '*'					# Put multiply operator in $s1
	j 	inputloop				# Wait for the new input
power:	
	li 	$s1, 'p'					# Put power operator in $s1
	j 	inputloop				# Wait for the new input
domultiplication:
	lw 	$t1, ($sp)				# Get the second operand from the stack
	addi 	$sp, $sp, 4				# Free up the space in stack
	lw 	$t0, ($sp)				# Get the first operand from the stack
	addi 	$sp, $sp, 4				# Free up the space in stack	 
	mul 	$t0, $t0, $t1				# Multiply both the operands
	addi 	$sp, $sp, -4				# Make space in stack
	sw 	$t0, ($sp)				# Store the result back in the stack
	li 	$s1, 0					# Reset $s1 to 0
	beq 	$s3, ';', endofstatement
	j 	inputloop				# Wait for the new input
takepower:
	lw 	$t1, ($sp)				# Get the second operand from the stack
	addi 	$sp, $sp, 4				# Free up the space in stack
	lw 	$t0, ($sp)				# Get the first operand from the stack
	addi	$sp, $sp, 4				# Free up the space in stack	 
	li 	$t2, 1					# $s6 will store the result of power operation
powerloop:						# Loop to take power
	beqz 	$t1, endpowerloop			# Keep multiplying until the power counter reaches 0
	mul 	$t2, $t2, $t0				# Keep on multiplying the number
	addi 	$t1, $t1, -1				# Decrement the power counter
	j 	powerloop				# Repeat
endpowerloop:	
	addi 	$sp, $sp, -4				# Make space in stack
	sw 	$t2, ($sp)				# Store the result back in the stack
	li 	$s1, 0					# Reset $s1 to 0
	beq 	$s3, ';', endofstatement
	j 	inputloop				# Wait for the new input
divide:
	lw 	$t1, ($sp)				# Get the second operand from the stack
	addi 	$sp, $sp, 4				# Free up the space in stack
	lw 	$t0, ($sp)				# Get the first operand from the stack
	addi 	$sp, $sp, 4				# Free up the space in stack	 
	div 	$t0, $t0, $t1				# Divide both the operands
	addi 	$sp, $sp, -4				# Make space in stack
	sw 	$t0, ($sp)				# Store the result back in the stack
	j 	inputloop				# Wait for the new input
endofstatement:
	blt 	$s2, '0', continue			# Check if the last character was a digit, if not ignore
	bgt 	$s2, '9', continue			# Check if the last character was a digit, if not ignore
	addi 	$sp, $sp, -4				# Make space in stack
	sw 	$s0, ($sp)				# Store the operand in the stack
continue:	
	li 	$t1, 0
	beq 	$fp, $sp, print_zero
	beq 	$s1, '*', domultiplication		# If the last operation was '*', do multiplication
	beq 	$s1, 'p', takepower			# If the last operation was 'p', take power		
	lui 	$t0,0xffff				# $t0 = 0xffff0000	
waitloop:
	lw 	$t1, 8($t0)				# Get the control word in $t1
	andi 	$t1,$t1,0x0001				# Get the status
	beq 	$t1, $0, waitloop			# Check if ready to output to MMIO, if not wait
	lw 	$t1, ($sp)				# Get the result from the stack
	addi 	$sp, $sp, 4				# Free up the space in stack
print_zero:	
	sw 	$t1, 12($t0)				# Write the result to MMIO
	move 	$sp, $fp					# Restore stack pointer
	j 	main					# Process new expression now
	
	# Quit
	li 	$v0, 10					# Syscall no to exit
	syscall						# Exit from the program
