#include <stdio.h>

int main()
{
	int T;
	
	scanf_s("%d", &T);

	while (T-- > 0) {
		long long x, y;

		scanf_s("%lld %lld", &x, &y);

		long long dist = y - x;

		if (dist <= 3) {
			printf("%.0lld\n", dist);
			continue;
		}
		long long N = 1;
		while (1) {
			if (N*N <= dist && dist < (N+1)*(N+1)) {
				long remain = dist - N * N;

				printf("%.0lld\n", 2*N-1 +((remain%N==0)?remain/N:remain/N+1) );
				
				break;
			}
			N++;
		}
	}
	return 0;
}
