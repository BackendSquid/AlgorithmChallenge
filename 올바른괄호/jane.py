def solution(s):
    x = 0
    for w in s:
        if x < 0:
            break
        if w == "(":
            x = x + 1
        elif w == ")":
            x = x - 1
        else:
            continue
    return x == 0
