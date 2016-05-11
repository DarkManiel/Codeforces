__author__ = 'markdaniel'
import math
full_circle = 360.0

def does_fit(plates, t_radius, p_radius):
    a = b = t_radius - p_radius
    if a <= 0:
        return "YES" if plates == 1 and a == 0 else "NO"
    if a < p_radius:
        return "YES" if plates == 1 else "NO"
    c = float(2 * p_radius)
    cosC = ((a*a + b*b) - (c*c)) / (2*a*b)
    angleC = round(math.degrees(float(math.acos(cosC))))

    return "YES" if (full_circle / angleC) >= plates else "NO"

if __name__ == '__main__':
    plates, t_radius, p_radius = [int(x) for x in input().split(' ')]
    print(does_fit(plates, t_radius, p_radius))