char salt = '#';

int Transform(char bytes[], int count)
{
	register int i;

	for(i = 0; i < count; ++i)
	{
		bytes[i] ^= salt;
	}

	return count;
}

