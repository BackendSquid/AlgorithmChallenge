def solution(m, musicinfos):
    m = replace(m)
    
    result = '(None)'
    max_m = 0
    for mi in musicinfos:
        start, end, name, melody = mi.split(',')
        melody = replace(melody)
        diff_m = diff(start, end)
        if len(melody) < diff_m:
            melody *= diff_m // len(melody)
            melody += melody[0:diff_m % len(melody)]
        elif len(melody) > diff_m:
            melody = melody[:diff_m]
        if ((m in melody) or (melody in m)) and max_m < diff_m:
            result = name
            max_m = diff_m
    return result

def replace(string):
    result = string.replace('C#', 'c')
    result = result.replace('D#', 'd')
    result = result.replace('F#', 'f')
    result = result.replace('G#', 'g')
    result = result.replace('A#', 'a')
    return result

def diff(start, end):
    start_h, start_m = start.split(':')
    end_h, end_m = end.split(':')
    diff_h = int(end_h) - int(start_h)
    diff_m = int(end_m) - int(start_m)
    if diff_m < 0:
        diff_h = diff_h - 1
        diff_m += 60
    return diff_h * 60 + diff_m
    