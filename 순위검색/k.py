from collections import defaultdict
import bisect

def solution(info, query):
    dictionary = defaultdict(list)
    for i in info:
        i_split = i.split()
        point = int(i_split[4])
        for k in getKeys(i_split):
            dictionary[k].append(point)
            
    for v in dictionary.values():
        v.sort()
    
    answer = []
    for q in query:
        q_split = q.split()
        key = q_split[0] + q_split[2] + q_split[4] + q_split[6]
        point = int(q_split[7])
        
        l = dictionary[key]
        answer.append(len(l) - bisect.bisect_left(l, point))
    
    return answer

def getKeys(i_split):
    result = []
    result.append(i_split[0]+i_split[1]+i_split[2]+i_split[3])
    result.append(i_split[0]+i_split[1]+i_split[2]+'-')
    result.append(i_split[0]+i_split[1]+'-'+i_split[3])
    result.append(i_split[0]+i_split[1]+'-'+'-')
    result.append(i_split[0]+'-'+i_split[2]+i_split[3])
    result.append(i_split[0]+'-'+i_split[2]+'-')
    result.append(i_split[0]+'-'+'-'+i_split[3])
    result.append(i_split[0]+'-'+'-'+'-')
    result.append('-'+i_split[1]+i_split[2]+i_split[3])
    result.append('-'+i_split[1]+i_split[2]+'-')
    result.append('-'+i_split[1]+'-'+i_split[3])
    result.append('-'+i_split[1]+'-'+'-')
    result.append('-'+'-'+i_split[2]+i_split[3])
    result.append('-'+'-'+i_split[2]+'-')
    result.append('-'+'-'+'-'+i_split[3])
    result.append('-'+'-'+'-'+'-')
    return result
