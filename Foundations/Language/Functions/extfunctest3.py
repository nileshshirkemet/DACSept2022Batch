import ctypes

lib = ctypes.CDLL('./primes.so')
upper = int(input('Upper Limit: '))
print('Number of Primes =', lib.CountPrimes(1, upper))

