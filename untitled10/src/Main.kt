fun main() {
    val pointA = Point(0.0, 0.0)
    val pointB = Point(4.0, 0.0)
    val pointC = Point(2.0, 3.0)
    val triangle = Triangle(pointA, pointB, pointC)
    val circle = Circle(triangle)
    println("Центр окружности: (${circle.center.x}, ${circle.center.y})")
    println("Радиус окружности: ${circle.radius}")
}
class Point(val x: Double, val y: Double)
class Triangle(val a: Point, val b: Point, val c: Point)
class Circle(val triangle: Triangle) {
    val center: Point
    val radius: Double
    init {
        val x1 = triangle.a.x
        val y1 = triangle.a.y
        val x2 = triangle.b.x
        val y2 = triangle.b.y
        val x3 = triangle.c.x
        val y3 = triangle.c.y
        val A = 2 * (x2 - x1)
        val B = 2 * (y2 - y1)
        val C = 2 * (x3 - x1)
        val D = 2 * (y3 - y1)
        val E = x2 * x2 - x1 * x1 + y2 * y2 - y1 * y1
        val F = x3 * x3 - x1 * x1 + y3 * y3 - y1 * y1
        val denominator = A * D - B * C
        val centerX = (D * E - B * F) / denominator
        val centerY = (A * F - C * E) / denominator
        center = Point(centerX, centerY)
        radius = Math.sqrt((centerX - x1) * (centerX - x1) + (centerY - y1) * (centerY - y1))
    }
}