function solution(s) {
  const stack = [];

  for (const c of s) {
    if (c === '(') {
      stack.push(c);
      continue;
    }

    if (stack.length === 0) {
      return false;
    }

    if (stack[stack.length - 1] !== '(') {
      return false;
    }

    stack.pop();
  }

  return stack.length === 0;
}
