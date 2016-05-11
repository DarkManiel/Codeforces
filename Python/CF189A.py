__author__ = 'markdaniel'
import queue as Q

a = -1; b = -1; c = -1

def dp(goal):
    cache = [0] * (goal + 1)
    paths = [a, b, c]

    for i in range(3):
        # print(i)
        if paths[i] > goal:
            paths[i] = goal
        cache[paths[i]] = max(cache[paths[i]], 1)
        q = Q.Queue(0)
        q.put(paths[i])

        while not q.empty():
            j = q.get()
            if (j + paths[0]) < len(cache) and cache[j + paths[0] - paths[i]] > 0:
                prev = cache[j + paths[0]]
                cache[j + paths[0]] = max(cache[j + paths[0]], 1 + cache[j + paths[0] - paths[i]])
                if cache[j + paths[0]] > prev:
                    q.put(j + paths[0])
            if (j + paths[1]) < len(cache) and cache[j + paths[1] - paths[i]] > 0:
                prev = cache[j + paths[1]]
                cache[j + paths[1]] = max(cache[j + paths[1]], 1 + cache[j + paths[1] - paths[i]])
                if cache[j + paths[1]] > prev:
                    q.put(j + paths[1])
            if (j + paths[2]) < len(cache) and cache[j + paths[2] - paths[i]] > 0:
                prev = cache[j + paths[2]]
                cache[j + paths[2]] = max(cache[j + paths[2]], 1 + cache[j + paths[2] - paths[i]])
                if cache[j + paths[2]] > prev:
                    q.put(j + paths[2])


    return cache[goal]

if __name__ == '__main__':
    vals = [int(x) for x in input().split(' ')]
    goal = vals[0]
    lens = sorted(vals[1:4])
    a = lens[0]
    b = lens[1]
    c = lens[2]
    level = 0
    print(dp(goal))

