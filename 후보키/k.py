def solution(relation):
    column_len = len(relation[0])
    
    candidate_keys = []
    
    def contains_key(key, column_indexes):
        for c in key:
            if c not in column_indexes:
                return False
        return True
    
    def is_minimality(column_indexes):
        for key in candidate_keys:
            if contains_key(key, column_indexes):
                return False
        
        return True
    
    def get_val(column_indexes, t):
        result = []
        for i in column_indexes:
            result.append(t[i])
        return ','.join(result)
    
    def check_uniqueness(column_indexes):
        s = set()
        
        for t in relation:
            v = get_val(column_indexes, t)
            if v in s:
                return
            s.add(v)
        
        candidate_keys.append(column_indexes[:])
    
    def check_minimality_and_uniqueness(column_indexes):
        if is_minimality(column_indexes):
            check_uniqueness(column_indexes)
            
    def combi(column_indexes, start, order):
        if len(column_indexes) == order:
            check_minimality_and_uniqueness(column_indexes)
            return
        
        for i in range(start, column_len):
            column_indexes.append(i)
            combi(column_indexes, i + 1, order)
            column_indexes.pop()
        
    for order in range(1, column_len + 1):
        column_indexes = []
        combi(column_indexes, 0, order) 
    
    return len(candidate_keys)
