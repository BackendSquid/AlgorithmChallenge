def solution(rows, columns, queries):
    matrix = make_matrix(rows, columns)
    
    answer = []
    def execute_query(query):
        min_value = 100000
        x1, y1, x2, y2 = query
        current = [x1, y1]
        prev = getMatrixValue(matrix, current)
        for _ in range(2 * (x2 - x1 + y2 - y1)):
            np = next_point(current, query)
            tmp = getMatrixValue(matrix, np)
            min_value = min(min_value, tmp)
            setMatrix(matrix, np, prev)
            prev = tmp
            current = np
        
        return min_value
    
    for query in queries:
        answer.append(execute_query(query))
    
    return answer

def make_matrix(rows, columns):
    matrix = []
    for i in range(rows):
        row = []
        for j in range(columns):
            num = columns * i + j + 1
            row.append(num)
        matrix.append(row)
    return matrix

def next_point(current, query):
    x1, y1, x2, y2 = query
    cur_x, cur_y = current
    
    if (cur_x == x1 and cur_y < y2):
        return [cur_x, cur_y + 1]
    if (cur_y == y2 and cur_x < x2):
        return [cur_x + 1, cur_y]
    if (cur_x == x2 and y1 < cur_y):
        return [cur_x, cur_y - 1]
    return [cur_x - 1, cur_y]

def getMatrixValue(matrix, point):
    x, y = point
    return matrix[x - 1][y - 1]

def setMatrix(matrix, point, value):
    x, y = point
    matrix[x - 1][y - 1] = value
