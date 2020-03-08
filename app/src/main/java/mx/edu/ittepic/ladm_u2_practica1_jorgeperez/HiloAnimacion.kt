package mx.edu.ittepic.ladm_u2_practica1_jorgeperez

class HiloAnimacion(p: MainActivity) : Thread() {
    var puntero = p

    override fun run() {
        super.run()
        sleep(6000) // Tiempo de espera para que los copos comiencen a caer
        while (true) {
            sleep(150) // Velocidad de caída de los copos
            puntero.runOnUiThread {
                puntero.lienzo!!.downNieve()
            }
        }
    }
}