#include <stdio.h>
#include <stdbool.h>
#include <string.h>

int main() {
	bool pass = false;
	char input[12];
	char password[] = "********";

	printf("Addresses: %ld\n", (long) &pass - (long) &input);
	printf("Please enter the password: ");
	scanf("%s", input);
	if (strcmp(input, password)) 
	{
		printf("Password does not match\n");
	} 
	else 
	{
		printf("Password matches!\n");
		pass = true;
	}
	if (pass) 
	{
		printf("Access granted");
	}
}
