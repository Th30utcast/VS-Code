#include<stdio.h>
#include<stdlib.h>

typedef struct {
    int** matrix;
} TwoD;

void make_matrix(TwoD* arr, size_t n) {
    arr->matrix = (int**)malloc(n * sizeof(int*));
    if (arr->matrix == NULL) {
        fprintf(stderr, "Memory allocation failed for the 2D array\n");
        exit(1);
    }
    for (int i = 0; i < n; i++) {
        arr->matrix[i] = (int*)malloc(n * sizeof(int));
    }
}

void fill_matrix(TwoD *arr, size_t n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            scanf("%d", &(arr->matrix[i][j]));
        }
    }
}


void print_matrix(TwoD* arr, size_t n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%3d ", arr->matrix[i][j]);
        }
        printf("\n");
    }
}

void add_mat_vec(TwoD *arr, size_t n, int *vec)
{
    for (int i = 0; i < n; i++)
    {
        int result = 0;
        for (int j = 0; j < n; j++)
        {
            result += arr->matrix[i][j] * vec[j];
        }
        printf("%d\n", result);
    }
}

void free_matrix(TwoD* arr, size_t n) {
    for (int i = 0; i < n; i++) {
        free(arr->matrix[i]);
    }
    free(arr->matrix);
}

int main() {
    TwoD* mat = (TwoD*)malloc(sizeof(TwoD));
    size_t n;
    
    // this is the size of the matrix
    scanf("%lu", &n);
    
    // initialize matrix
    make_matrix(mat, n);
    
    // fill matrix
    fill_matrix(mat, n);
    
    // make the vector array
    int* vec = (int*)malloc(n * sizeof(int));
    for (int i = 0; i < n; i++) {
        scanf("%d", &vec[i]);
    }
    
    // add the matrix with the vector
    add_mat_vec(mat, n, vec);
    
    // free everything
    free(vec);
    free_matrix(mat, n);
    
    return 0;
}
