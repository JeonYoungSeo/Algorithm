#include <stdio.h>

int main()
{
	int N;

	scanf_s("%d", &N);

	int num5, num3;

	num5 = N / 5 + 1;

	for (int i = num5; i >= 0; i--) {
		if (N - i * 5 < 0) continue;
		if ((N - (i * 5)) % 3 == 0) {
			num5 = i;
			num3 = (N - (num5 * 5)) / 3;
			printf("%d\n", num5 + num3);
			return 0;
		}
	}

	printf("-1\n");
	return 0;
}
