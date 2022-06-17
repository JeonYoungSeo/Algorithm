word = input()

list = list()

for i in range(len(word)) :
    list.append(word[i:len(word)])

list.sort()

for w in list :
    print(w)
