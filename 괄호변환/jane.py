def solution(p):
    if p == '':
        return p

    left = 0
    right = 0
    u = ''
    v = ''
    for i in range(len(p)):
        if p[i] == '(':
            left += 1
        elif p[i] == ')':
            right += 1
        if left == right:
            u = p[:i + 1]
            v = p[i + 1:]
            break

    if isRight(u):
        return u + solution(v)
    else:
        return '(' + solution(v) + ')' + reverse(u)


def reverse(u):
    u = u[1:-1]
    temp = ''
    for i in u:
        if i == '(':
            temp += ')'
        else:
            temp += '('
    return temp


def isRight(u):
    stack = []
    for i in u:
        if i == '(':
            stack.append('(')
        else:
            if len(stack) == 0:
                continue
            elif stack[-1] == '(':
                stack.pop(-1)
            else:
                stack.append(')')
    if len(stack) != 0:
        return False
    return True
