def solution(enter, leave):
    entered = set()
    
    next_enter_index = 0
    next_leave_index = 0
    
    answer = [0] * len(enter)
    
    def enter_person(person):
        answer[person - 1] = len(entered)
        for p in entered:
            answer[p - 1] += 1
        entered.add(person)
    
    while next_leave_index < len(leave):
        if len(entered) == 0:
            entered.add(enter[next_enter_index])
            next_enter_index += 1
            continue
        if leave[next_leave_index] in entered:
            entered.remove(leave[next_leave_index])
            next_leave_index += 1
            continue
        if leave[next_leave_index] not in entered:
            enter_person(enter[next_enter_index])
            next_enter_index += 1
    
    return answer
