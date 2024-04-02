//Take everyhting & place it in an array of char (malloc) + "get the size so i can use a for loop"
// Loop over the array, if the ACII of i is between 48 and 57
    // check for the full digit number
    // get the number and save it
// check for the full operator 
    // p,s -> +
    // m,s -> -
    // t,s -> *
    // t,f -> ^
//return the final int i.e the sum of every operation

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <math.h>

typedef enum 
{
    OPERATOR_PLUS,
    OPERATOR_MINUS,
    OPERATOR_TIMES,
    OPERATOR_TOTHEPOWEROF,
    OPERATOR_NONE
} Operator;

typedef struct 
{
    char *array;
    int size;
} InputResult;

Operator getOperator(const char *operatorStr) 
{
    if(strcmp(operatorStr, "plus") == 0) 
    {
        return OPERATOR_PLUS;
    } 
    else if(strcmp(operatorStr, "minus") == 0) 
    {
        return OPERATOR_MINUS;
    } 
    else if(strcmp(operatorStr, "times") == 0)
    {
        return OPERATOR_TIMES;
    } 
    else if(strcmp(operatorStr, "tothepowerof") == 0) 
    {
        return OPERATOR_TOTHEPOWEROF;
    }
    return OPERATOR_NONE;
}

void deallocateCharMemory(char *arrayofstrings) 
{
    free(arrayofstrings);
}

char *allocateCharMemory(size_t size) 
{
    char *arrayofstrings = (char *)malloc(sizeof(char) * size);
    return arrayofstrings;
}

InputResult readInput(size_t size) 
{
    char *arrayofstrings = allocateCharMemory(size);
    int tracker = 0;
    char input = '\0';  // initialize input

    while (input != '\n') 
    {
        if (tracker == size - 1) 
        {
            size *= 2;
            char *temp = (char *)realloc(arrayofstrings, sizeof(char) * size);
            arrayofstrings = temp;
        }
        input = getc(stdin); // getting the input from standard in (keyboard)
        arrayofstrings[tracker] = input; // storing the input
        tracker++; // increment tracker
    }
    arrayofstrings[tracker - 1] = '\0'; // NULL-terminate the string
    // tracker - 1 is now the size of the entire string.
    InputResult result = {arrayofstrings, tracker - 1};
    return result;
}

int performOperation(int currentResult, Operator op, int number) 
{
    switch (op) 
    {
        case OPERATOR_PLUS:
            return currentResult + number;
        case OPERATOR_MINUS:
            return currentResult - number;
        case OPERATOR_TIMES:
            return currentResult * number;
        case OPERATOR_TOTHEPOWEROF:
            if(currentResult == 0 && number == 0) 
            {
                return 1; // special case: 0^0 = 1
            } 
            else 
            {
                return pow(currentResult, number);
            }
        default:
            return currentResult; // default case, if operator not recognized
    }
}

void parseInput(InputResult input)
{
    int currentResult =0;
    Operator currentOp =OPERATOR_NONE;
    int i =0;
    int firsnum =0;
    while(i < input.size) // loops over the array
    {
        if(isdigit(input.array[i])) // checks if i is a digit
        {
            int num=0;
            while(isdigit(input.array[i])) // if it's a digit handle it being more than 1 digit int
            {
                num = num*10+(input.array[i]-'0'); // str[i] -'0' returns the actual int of a char
                i++;
            }
            if(!firsnum)
            {
                currentResult = num; // Initialize currentResult with the first number
                firsnum = 1;
            }
            else
            {
            currentResult = performOperation(currentResult,currentOp,num); 
            }
            currentOp = OPERATOR_NONE; // Reset operator for next operation
        } 
        else if(!isspace(input.array[i])) // if it's not a space
        {
            int j = 0;
            char operatorStr[15];
            while(input.array[i] != '\0' && !isdigit(input.array[i]) && !isspace(input.array[i])) // if you don't find a int or space then keep adding to the array
            {
                operatorStr[j++] = input.array[i++];
            }
            operatorStr[j] = '\0'; // add a NULL-terminator at the end
            currentOp = getOperator(operatorStr);
        } 
        else 
        {
            i++;
        }
    }
    printf("%d", currentResult);
}

int main() {
    size_t initialSize = 10;
    InputResult input = readInput(initialSize);
    parseInput(input);
    deallocateCharMemory(input.array);
    return 0;
}