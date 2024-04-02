#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<stdbool.h>
#include<ctype.h>
#include<string.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/mman.h>
#include<sys/wait.h>
int main(int argc, char **argv){
	int n = atoi(argv[1]);
	int sharedArr = (int) mmap(NULL,sizeof(int)*n,PROT_READ | PROT_WRITE, MAP_SHARED | MAP_ANONYMOUS,-1,0);
	
	if(sharedArr == MAP_FAILED){
		perror("Falied : mmap");
		exit(EXIT_FAILURE);
	}
	
	
	pid_t child = fork();
	if (child < 0){
		printf("Error");
	}
	else if (child == 0){
		printf("From Child, please enter %d integers : ",n);
		for (int i = 0 ; i < n ; i++){
		int a;
		scanf("%d",&a);
		sharedArr[i] = a;}
		int sum = 0;
		for (int i = 0 ; i < n ; i++){
			sum+=sharedArr[i];
		}
		for (int i = 0; i < n;i++){
			printf("%d ",sharedArr[i]);
		}
		printf("\n");
		printf("Sum is: %d\n",sum);
		
	} 
	else{
		wait(NULL);
		int a;
		printf("From Parent, please enter a: ");
		scanf("%d",&a);
		
		for (int i = 0; i < n ; i++){
			sharedArr[i]*=a;
			printf("%d ",sharedArr[i]);
		}
	}
	return 0;
}