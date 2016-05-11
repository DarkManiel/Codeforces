__author__ = 'markdaniel'

def accumulate(maybeFirst, k):
    sum = 0
    i = 0
    curCodeSprint = maybeFirst // (k ** i)

    while curCodeSprint >= 1:
        sum += curCodeSprint
        i += 1
        curCodeSprint = maybeFirst // (k ** i)
    return sum

def binarySearch(n, k):
    lo = 0
    hi = n
    while lo <= hi:
        mid = (lo + hi)// 2
        if accumulate(mid, k) < n:
            lo = mid + 1
        else:
            hi = mid - 1
    return hi + 1

if __name__ == '__main__':
    n, k = input().split(' ')
    print(binarySearch(int(n), int(k)))
