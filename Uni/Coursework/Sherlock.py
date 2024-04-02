"""This script simulates a simple instruction set for manipulating registers and memory,
it's like making MIPS, but in python :)
It supports operations like load, store, arithmetic operations, conditional jumps,
and printing values. The script interacts with users through a command-line interface,
accepting instructions until "END" is input. When the user inputs the respective command
the program will do the respective action"""


# LOAD a value from long-term memory into a specified register using the ADDress in register A
def LOAD(MEM):
    if MEM in short_term_reg:
        LOADA(MEM, short_term_reg["A"])
        short_term_reg["X"] += 1
    else:
        error()


# Set a specified register to a specific value
def LOADI(MEM, value):
    if MEM in short_term_reg:
        short_term_reg[MEM] = int(value)
        short_term_reg["X"] += 1
    else:
        error()


# LOAD a value from long-term memory into a specified register
def LOADA(MEM, ADDR):
    if MEM in short_term_reg and 0 <= ADDR < 2048:
        short_term_reg[MEM] = long_term_reg[ADDR]
        short_term_reg["X"] += 1
    else:
        error()


# STORE the value from a specified register into long-term memory using the ADDress in register A
def STORE(MEM):
    if MEM in short_term_reg:
        STOREA(MEM, short_term_reg["A"])
        short_term_reg["X"] += 1
    else:
        error()


# STORE the value from a specified register into long-term memory
def STOREA(MEM, ADDR):
    if MEM in short_term_reg and 0 <= ADDR < 2048:
        long_term_reg[ADDR] = short_term_reg[MEM]
        short_term_reg["X"] += 1
    else:
        error()


# Move the value from one register to another
def MOVE(MEM_1, MEM_2):
    if MEM_1 in short_term_reg and MEM_2 in short_term_reg:
        short_term_reg[MEM_1] = short_term_reg[MEM_2]
        short_term_reg["X"] += 1
    else:
        error()


# ADD the values of two registers and STORE the result in the first register
def ADD(MEM_1, MEM_2):
    if MEM_1 and MEM_2 in short_term_reg:
        short_term_reg[MEM_1] += short_term_reg[MEM_2]
        short_term_reg["X"] += 1

    else:
        error()


# ADD a value to a specified register
def ADDI(MEM, value):
    if MEM in short_term_reg:
        short_term_reg[MEM] += int(value)
        short_term_reg["X"] += 1
    else:
        error()


# Subtract the value of one register from another and STORE the result
def SUB(MEM_1, MEM_2):
    if MEM_1 and MEM_2 in short_term_reg:
        short_term_reg[MEM_1] -= short_term_reg[MEM_2]
        short_term_reg["X"] += 1
    else:
        error()


# MULtiply the values of two registers and STORE the result
def MUL(MEM_1, MEM_2):
    if MEM_1 and MEM_2 in short_term_reg:
        short_term_reg[MEM_1] *= short_term_reg[MEM_2]
        short_term_reg["X"] += 1
    else:
        error()


# DIVide the value of one register by another and STORE the result
def DIV(MEM_1, MEM_2):
    if MEM_1 and MEM_2 in short_term_reg and short_term_reg[MEM_2] != 0:
        short_term_reg[MEM_1] //= short_term_reg[MEM_2]
        short_term_reg["X"] += 1
    else:
        error()


# Jump a specified number of instructions forward or backward
def JMP(steps):
    step = int(steps)
    if step != -1 and step != 0:
        if short_term_reg["P"] + step < len(counter):
            short_term_reg["P"] += step
            short_term_reg["X"] += 1
    else:
        error()


# Conditional jump based on the value in a specified register
def JMPR(MEM):
    value = short_term_reg[MEM]
    pos = short_term_reg["P"] + value - 1
    if 0 <= pos < len(counter):
        short_term_reg["P"] = pos
        short_term_reg["X"] += 1
    else:
        error()


# Jump if the value in a specified register is zero
def JZ(MEM, steps):
    if short_term_reg[MEM] == 0:
        JMP(steps)
        short_term_reg["X"] += 1
    else:
        error()


# Conditional jump if the value in one register is less than another
def JLT(MEM_1, MEM_2, steps):
    if MEM_1 in short_term_reg and MEM_2 in short_term_reg:
        if short_term_reg[MEM_1] < short_term_reg[MEM_2]:
            JMP(int(steps))
        else:
            short_term_reg["X"] += 1
    else:
        error()


# Print the value in a specified register
def PRINT(MEM):
    if MEM in short_term_reg:
        print(short_term_reg[MEM])
        short_term_reg["X"] += 1
    else:
        error()


# Error handling function to terminate the program on invalid operations
def error():
    print("I'm afraid I can't do that")
    exit()


short_term_reg = {"A": 0, "B": 0, "C": 0, "D": 0, "P": 0, "X": 0}
long_term_reg = [0] * 2048
counter = []


# Checks which operator is going to be executed
def execution_op(current):
    input_command = current.split()
    instruction = input_command[0]

    if instruction == "LOADA":
        LOADA(input_command[1], int(input_command[2]))
    elif instruction == "LOAD":
        LOAD(input_command[1])
    elif instruction == "LOADI":
        LOADI(input_command[1], int(input_command[2]))
    elif instruction == "STOREA":
        STOREA(input_command[1], int(input_command[2]))
    elif instruction == "STORE":
        STORE(input_command[1])
    elif instruction == "MOVE":
        MOVE(input_command[1], (input_command[2]))
    elif instruction == "ADDI":
        ADDI(input_command[1], int(input_command[2]))
    elif instruction == "ADD":
        ADD(input_command[1], input_command[2])
    elif instruction == "SUB":
        SUB(input_command[1], input_command[2])
    elif instruction == "MUL":
        MUL(input_command[1], input_command[2])
    elif instruction == "DIV":
        DIV(input_command[1], input_command[2])
    elif instruction == "JMP":
        JMP(int(input_command[1]))
    elif instruction == "JMPR":
        JMPR(input_command[1])
    elif instruction == "JZ":
        JZ(input_command[1], int(input_command[2]))
    elif instruction == "JLT":
        JLT(input_command[1], input_command[2], int(input_command[3]))
    elif instruction == "PRINT":
        PRINT(input_command[1])
    else:
        error()

    short_term_reg["P"] += 1


def main():
    while True:
        read = input().upper()
        if read == "END":
            break
        counter.append(read)
    short_term_reg["P"] = 0
    while short_term_reg["P"] < len(counter):
        current = counter[short_term_reg["P"]]
        execution_op(current)


main()
