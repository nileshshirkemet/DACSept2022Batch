int Transform(char bytes[], int count)
{
	register int i, j;

	for(i = 0, j = count - 1; i < j; ++i, --j)
	{
		char ib = bytes[i];
		char jb = bytes[j];

		bytes[i] = jb;
		bytes[j] = ib;
	}

	return count;
}

