def solution(s):
    stack = []
    if (len(s) % 2 != 0):
        return 0
    for char in s:
        if len(stack) != 0 and stack[-1] == char:
            stack.pop(-1)
        else:
            stack.append(char)

    if len(stack) == 0:
        return 1
    else:
        return 0