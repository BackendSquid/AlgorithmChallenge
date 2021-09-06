import sys

vowels = ['A', 'E', 'I', 'O', 'U']
sys.setrecursionlimit(100000)

arr = []


def dfs(v, depth):
    if depth > 5:
        return
    arr.append(v)
    for vowel in vowels:
        dfs(v + vowel, depth + 1)


def solution(word):
    dfs('', 0)
    print(arr)
    for i in range(len(arr)):
        if arr[i] == word:
            return i
