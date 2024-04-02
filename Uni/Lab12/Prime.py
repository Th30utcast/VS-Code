def check_if_prime(a):
    if a <= 1:
        return False
    for i in range(2, int(a**0.5) + 1):
        if a % i == 0:
            return False
    return True

a = int(input("Enter a number: "))
if check_if_prime(a):
    print("Is prime")
else:
    print("Is not prime")
