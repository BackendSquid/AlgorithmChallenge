import unittest


def solution(s):

    if len(s) % 2 == 1:
        return 0

    stack = []

    for i in s:
        if len(stack) > 0 and i == stack[-1]:
            stack.pop()
        else:
            stack.append(i)

    if len(stack) == 0:
        return 1
    
    return 0


class TestClass(unittest.TestCase):

    def test_case_one(self):
        self.assertEqual(solution('baabaa'), 1)

    def test_case_two(self):
        self.assertEqual(solution("abcccba"), 0)
