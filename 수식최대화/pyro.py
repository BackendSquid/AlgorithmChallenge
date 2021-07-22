# https://programmers.co.kr/learn/courses/30/lessons/67257

priorities = (('+', '-', '*'),
('+', '*', '-'),
('-', '+', '*'),
('-', '*', '+'),
('*', '+', '-'),
('*', '-', '+'))

def operate(num1, num2, operation):
    if operation == '+':
        return int(num1) + int(num2)
    if operation == '-':
        return int(num1) - int(num2)
    if operation == '*':
        return int(num1) * int(num2)

def expression2words(expression):
    words = []
    num_str = ""
    for char in expression:
        if char.isdecimal():
            num_str += char
        else:
            words.append(num_str)
            words.append(char)
            num_str = ""
    words.append(num_str)
    return words

def calculate(expression, priority):
    words = expression2words(expression)
    for operation in priority:
        stack = []
        while len(words) > 0:
            word = words.pop(0)
            if word == operation:
                stack.append(operate(stack.pop(), words.pop(0), operation))
            else:
                stack.append(word)
        words = stack
    return abs(int(words[0]))

def solution(expression):
    result = 0
    for priority in priorities:
        result = max(result, calculate(expression, priority))
    return result
