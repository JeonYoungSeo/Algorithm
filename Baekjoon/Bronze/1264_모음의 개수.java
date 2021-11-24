while True :
    str = input()
    if(str == '#') :
        break

    result = 0
    result += str.count('a')
    result += str.count('A')
    result += str.count('e')
    result += str.count('E')
    result += str.count('i')
    result += str.count('I')
    result += str.count('o')
    result += str.count('O')
    result += str.count('u')
    result += str.count('U')

    print(result)
