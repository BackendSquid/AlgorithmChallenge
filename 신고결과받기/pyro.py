from collections import defaultdict

def solution(id_list, report, k):
    reporter_dict = defaultdict(list)
    reportee_count = defaultdict(int)
    for r in set(report):
        [reporter, reportee] = r.split(" ")
        reporter_dict[reporter].append(reportee)
        reportee_count[reportee] += 1
    
    answer = []
    for reporter in id_list:
        mail_count = sum(reportee_count[reportee] >= k \
                         for reportee in reporter_dict[reporter])
        answer.append(mail_count)
    return answer
