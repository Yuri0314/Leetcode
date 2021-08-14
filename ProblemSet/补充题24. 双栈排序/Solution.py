def stackSort(stk):
    tmp = []
    while stk:
        peak = stk.pop()
        while tmp and tmp[-1] > peak:
            t = tmp.pop()
            stk.append(t)
        tmp.append(peak)
    return tmp