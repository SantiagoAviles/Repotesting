import math

def isPrime(number):
    if number == 2:
        return True
    if number<=1 or (number%2)==0:
        return False
    for check in range(3,int(math.sqrt(number))):  
        if (number%check) == 0:  
            return False
    return True

def test():
    assert isPrime(1) == False
    assert isPrime(2) == True
    assert isPrime(3) == True
    assert isPrime(4) == False
    assert isPrime(5) == True
    assert isPrime(20) == False
    assert isPrime(21) == False
    assert isPrime(22) == False
    assert isPrime(23) == True
    assert isPrime(24) == False
    assert isPrime(9) == False  # <-- ESTE falla con el código original

def isPrime2(number):
    if number == 2:
        return True
    if number <= 1 or (number % 2) == 0:
        return False
    for check in range(3, int(math.sqrt(number)) + 1, 2):  # <= CORREGIDO
        if (number % check) == 0:
            return False
    return True

def test2():
    assert isPrime2(1) == False
    assert isPrime2(2) == True
    assert isPrime2(3) == True
    assert isPrime2(4) == False
    assert isPrime2(5) == True
    assert isPrime2(20) == False
    assert isPrime2(21) == False
    assert isPrime2(22) == False
    assert isPrime2(23) == True
    assert isPrime2(24) == False
    assert isPrime2(9) == False  # Ahora pasa correctamente
    
test2()
