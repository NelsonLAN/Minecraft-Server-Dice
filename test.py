import random
from array import *

dice = []
for i in range(3):
    dice.append(0)

print("Please enter roll time")
roll = int(input())


def roll_dice(qty, face, dice):
    for x in range(0, qty):
        dice[x] = random.randrange(1, face + 1)


def print_dice(dice):
    for x in range(0, qty - 1):
        print(dice[x])

def adding_dice(dice):
    sum = 0
    for x in range(0,qty):
        sum+=dice[x]
    print("Sum of dice = " + str(sum))

def clear_dice(dice):
    for x in range(0,qty):
        dice[x] = 0

while roll != 0:
    print("Please enter faces of dices")
    face = int(input())
    print("Please enter qty of dices")
    qty = int(input())

    if face >= 2 and qty >= 1:
        roll_dice(qty, face, dice)
        print(dice)
    else:
        print("Error #1 -- Invalid value")
        break;
    roll -= 1

    adding_dice(dice)
    print("Remain roll:" + str(roll))
    clear_dice(dice)
