registers = {"A": 0, "B": 0, "C": 0, "D": 0, "P": 0, "X": 0}
memory_block = [0] * 2048
program_instructions = []

def handle_error():
    print("Operation cannot be completed.")
    exit()

def load_register_from_memory(register, address):
    if register in registers and 0 <= address < len(memory_block):
        registers[register] = memory_block[address]
        registers["X"] += 1
    else:
        handle_error()

def execute_load_instruction(register):
    if register in registers:
        load_register_from_memory(register, registers["A"])
        registers["X"] += 1
    else:
        handle_error()

def set_register_value(register, value):
    if register in registers:
        registers[register] = int(value)
        registers["X"] += 1
    else:
        handle_error()

def store_register_to_memory(register, address):
    if register in registers and 0 <= address < len(memory_block):
        memory_block[address] = registers[register]
        registers["X"] += 1
    else:
        handle_error()

def execute_store_instruction(register):
    if register in registers:
        store_register_to_memory(register, registers["A"])
        registers["X"] += 1
    else:
        handle_error()

def move_value_between_registers(dest, src):
    if dest in registers and src in registers:
        registers[dest] = registers[src]
        registers["X"] += 1
    else:
        handle_error()

def increment_register_by_value(register, value):
    if register in registers:
        registers[register] += int(value)
        registers["X"] += 1
    else:
        handle_error()

def add_register_values(dest, src):
    if dest in registers and src in registers:
        registers[dest] += registers[src]
        registers["X"] += 1
    else:
        handle_error()

def subtract_register_values(dest, src):
    if dest in registers and src in registers:
        registers[dest] -= registers[src]
        registers["X"] += 1
    else:
        handle_error()

def multiply_register_values(dest, src):
    if dest in registers and src in registers:
        registers[dest] *= registers[src]
        registers["X"] += 1
    else:
        handle_error()

def divide_register_values(dest, src):
    if dest in registers and src in registers and registers[src] != 0:
        registers[dest] //= registers[src]
        registers["X"] += 1
    else:
        handle_error()

def jump_instructions(steps):
    if steps != -1 and steps != 0 and (registers["P"] + steps) < len(program_instructions):
        registers["P"] += steps
        registers["X"] += 1
    else:
        handle_error()

def conditional_jump_based_on_register(register):
    jump_offset = registers[register]
    next_position = registers["P"] + jump_offset - 1
    if 0 <= next_position < len(program_instructions):
        registers["P"] = next_position
        registers["X"] += 1
    else:
        handle_error()

def jump_if_zero(register, steps):
    if registers[register] == 0:
        jump_instructions(steps)
        registers["X"] += 1
    else:
        handle_error()

def jump_if_less_than(reg1, reg2, steps):
    if reg1 in registers and reg2 in registers and registers[reg1] < registers[reg2]:
        jump_instructions(steps)
    else:
        registers["X"] += 1

def print_register_value(register):
    if register in registers:
        print(registers[register])
        registers["X"] += 1
    else:
        handle_error()

def run_program():
    while True:
        user_input = input()
        if user_input.upper() == "END":
            break
        program_instructions.append(user_input)
    registers["P"] = 0
    while registers["P"] < len(program_instructions):
        current_instruction = program_instructions[registers["P"]].split()
        operation = current_instruction[0].upper()

        operations = {
            "LOADA": lambda: load_register_from_memory(current_instruction[1], int(current_instruction[2])),
            "LOAD": lambda: execute_load_instruction(current_instruction[1]),
            "LOADI": lambda: set_register_value(current_instruction[1], int(current_instruction[2])),
            "STOREA": lambda: store_register_to_memory(current_instruction[1], int(current_instruction[2])),
            "STORE": lambda: execute_store_instruction(current_instruction[1]),
            "MOVE": lambda: move_value_between_registers(current_instruction[1], current_instruction[2]),
            "ADDI": lambda: increment_register_by_value(current_instruction[1], int(current_instruction[2])),
            "ADD": lambda: add_register_values(current_instruction[1], current_instruction[2]),
            "SUB": lambda: subtract_register_values(current_instruction[1], current_instruction[2]),
            "MUL": lambda: multiply_register_values(current_instruction[1], current_instruction[2]),
            "DIV": lambda: divide_register_values(current_instruction[1], current_instruction[2]),
            "JMP": lambda: jump_instructions(int(current_instruction[1])),
            "JMPR": lambda: conditional_jump_based_on_register(current_instruction[1]),
            "JZ": lambda: jump_if_zero(current_instruction[1], int(current_instruction[2])),
            "JLT": lambda: jump_if_less_than(current_instruction[1], current_instruction[2], int(current_instruction[3])),
            "PRINT": lambda: print_register_value(current_instruction[1])
        }

        if operation in operations:
            operations[operation]()
        else:
            handle_error()

        registers["P"] += 1

run_program()
