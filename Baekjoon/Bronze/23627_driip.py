word = input()

if(len(word)<5) :
    print("not cute")
else :
    if word[-5:] == "driip" :
        print('cute')
    else :
        print("not cute")
