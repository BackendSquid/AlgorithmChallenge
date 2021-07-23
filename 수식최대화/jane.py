from itertools import permutations
import copy


def solution(expression):
    answer = 0
    ops = ['+', '-', '*']
    ops_priorities_pm = list(permutations(ops))

    n_stack = []
    op_stack = []
    mark = 0

    for i in range(len(expression)):
        if expression[i] in ops:
            n_stack.append(expression[mark:i])
            op_stack.append(expression[i])
            mark = i + 1
    n_stack.append(expression[mark:len(expression)])

    n_stack = list(map(int, n_stack))

    for ops_tuple in ops_priorities_pm:
        current_op_priority = list(ops_tuple)
        op_temp = copy.deepcopy(op_stack)
        n_temp = copy.deepcopy(n_stack)
        for op in current_op_priority:
            print(op)
            idx = 0

            while idx < len(op_temp):
                if op == op_temp[idx]:
                    n_temp[idx] = calculate(n_temp[idx], n_temp[idx + 1], op_temp[idx])
                    n_temp.pop(idx + 1)
                    op_temp.pop(idx)
                    idx -= 1
                idx += 1
        answer = max(answer, abs(n_temp[0]))

    return answer


def calculate(x, y, op):
    if op == '+':
        return x + y
    if op == '-':
        return x - y
    return x * y
