# [숫자의 표현](https://programmers.co.kr/learn/courses/30/lessons/12924)

```txt
f(start, i) = start + (start + 1) + ... + (start + i - 1)
= (i * start) + 1 + ... + i - 1
= (i * start) + ( (i-1)*(1+i-1)/2 )
= i*start + i*(i-1)*0.5
= i*(start + (i-1)*0.5)
```

f(start,i) = n 를 만족하는 start 는 i 한개당 하나밖에 없다. <br>
즉 start 는 생각할 필요 없이 i 의 갯수만 구하면 된다. <br>
그렇다면 i의 조건을 좁혀보자.

i 는 1 부터 n 까지 가능하다. range(1, n+1)

f(start,i) = n 을 만족하려면, <br>
i 와 (start+(i-1)*0.5) 는 n 의 약수여야 한다.<br>
<-><br>
n%i == 0 && n%(start+(i-1)*0.5) == 0

(start+(i-1)*0.5) 이 약수이려면, 정수여야 한다.<br>
즉 (i-1)*0.5 는 정수여야 한다.<br>
-> i는 홀수이다.

"range(1, n+1)" 와 "i 는 홀수여야 한다"를 조합<br>
-> range(1, n+1, 2)

또한 i 는 n의 약수여야 한다.<br>
-> n % i == 0

결론:<br>
[i for i in range(1, n+1, 2) if n % i == 0]


```python
def solution(n):
    return len([i for i in range(1, n+1, 2) if n % i == 0])
```
