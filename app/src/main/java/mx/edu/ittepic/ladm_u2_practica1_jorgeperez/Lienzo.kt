package mx.edu.ittepic.ladm_u2_practica1_jorgeperez

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Lienzo(p: MainActivity) : View(p) {
    // Se necesita p para que View sepa cuál Activity va a trabajar
    var puntero = p

    // Crear el sol
    var sol = FiguraGeometrica(150, 150, 100)

    // Dibujar la nube
    var nube1 = FiguraGeometrica(450, 150, 50)
    var nube2 = FiguraGeometrica(500, 152, 50)
    var nube3 = FiguraGeometrica(550, 150, 50)
    var nube4 = FiguraGeometrica(600, 148, 50)
    var nube5 = FiguraGeometrica(650, 148, 50)

    // Dibujo de la casa
    var casa = FiguraGeometrica(370, 900, 500, 400)
    var ventana = FiguraGeometrica(450, 1070, 50)
    var puerta = FiguraGeometrica(600, 1160, 100, 140)

    // Dibujar el techo de la casa
    // Coordx = Alto punta del triángulo, Coordy = Alto del triángulo, p1x = inicio de la base, p2x = fin del ancho de base.
    var techo = FiguraGeometrica(630f, 510f, 370f, 900f, 870f, 900f)
    var punteroFiguraGeometrica: FiguraGeometrica? = null

    // Dibujar árbol
    var tronco = FiguraGeometrica(80, 1110, 130, 180)
    var hojas = FiguraGeometrica(140, 1050, 100)
    var hojas2 = FiguraGeometrica(140, 920, 100)


    // Dibujar nieve
    var nieve: Array<FiguraGeometrica> =
        Array(500) { FiguraGeometrica((0..1050).random(), (-1900..0).random(), 5) }

    // Dibujar pasto
    var pasto = FiguraGeometrica(0,1000,1200,2000)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint = Paint()
        // Fondo
        canvas.drawColor(Color.CYAN)

        // Pasto
        paint.color = Color.GREEN
        pasto.pintar(canvas,paint)

        // Sol
        paint.color = Color.YELLOW
        sol.pintar(canvas, paint)

        // Nube
        paint.color = Color.rgb(120, 120, 120)
        nube1.pintar(canvas, paint)
        nube2.pintar(canvas, paint)
        nube3.pintar(canvas, paint)
        nube4.pintar(canvas, paint)
        nube5.pintar(canvas, paint)

        // Casa
        paint.color = Color.rgb(21, 21, 255)
        casa.pintar(canvas, paint)

        // Ventana
        paint.color = Color.rgb(245, 0, 0)
        ventana.pintar(canvas, paint)

        // Techo
        paint.color = Color.rgb(206, 206, 206)
        techo.pintar(canvas, paint)

        // Puerta
        paint.style = Paint.Style.FILL
        paint.color = Color.rgb(245, 0, 0)
        puerta.pintar(canvas, paint)

        // Árbol
        paint.color = Color.rgb(128, 64, 0)
        tronco.pintar(canvas, paint)
        paint.color = Color.rgb(0, 64, 0)
        hojas.pintar(canvas, paint)
        hojas2.pintar(canvas, paint)

        // Copos de nieve
        paint.color = Color.WHITE

        (nieve.indices).forEach() {
            nieve[it].pintar(canvas, paint)
        } // Fin del forEach()

        // Bordes
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        paint.strokeWidth = 2f
        puerta.pintar(canvas, paint)
        ventana.pintar(canvas, paint)
        casa.pintar(canvas, paint)

    } // Fin de onDraw

    // Función para que caiga el copo de nieve
    fun downNieve() {
        (nieve.indices).forEach() {
            nieve[it].down(width, height)
        }
        invalidate()
    } // Fin de la función downNieve()

}   // Fin de la clase