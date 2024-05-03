package com.example.tt

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tt.ui.theme.TictactoeTheme

class MainActivity() : ComponentActivity(), OnClickListener, Parcelable {
    var PLAYER = true
    var TURN_COUNT = 0
    var boardStatus = Array(3){IntArray(3)}
    lateinit var board : Array<Array<Button>>
    val t = findViewById<TextView>(R.id.displayTv)

    constructor(parcel: Parcel) : this() {
        PLAYER = parcel.readByte() != 0.toByte()
        TURN_COUNT = parcel.readInt()
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1 = findViewById<Button>(R.id.button1)
        val btn2 = findViewById<Button>(R.id.button2)
        val btn3 = findViewById<Button>(R.id.button3)
        val btn4 = findViewById<Button>(R.id.button4)
        val btn5 = findViewById<Button>(R.id.button5)
        val btn6 = findViewById<Button>(R.id.button6)
        val btn7 = findViewById<Button>(R.id.button7)
        val btn8 = findViewById<Button>(R.id.button8)
        val btn9 = findViewById<Button>(R.id.button9)
        val reset = findViewById<Button>(R.id.reset)






        board = arrayOf(
            arrayOf(btn1,btn2,btn3),
            arrayOf(btn4,btn5,btn6),
            arrayOf(btn7,btn8,btn9)
        )

        for(i:Array<Button> in board){
            for(butt in i){
                butt.setOnClickListener(this)
        }




    }

     reset.setOnClickListener {
         PLAYER = true
         TURN_COUNT = 0
         initialiseBoardStatus()

     }
}

    private fun initialiseBoardStatus(){
        for(i in 0..2) {
            for (j in 0..2) {
                boardStatus[i][j] = -1
            }
        }
        for(i in board){
            for(btn in i ){
                btn.isEnabled = true
                btn.text = ""

            }
        }
    }

    private fun checkWinner(){
        for(i in 0..2){
            if(boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2]){
                if(boardStatus[i][0] == 1){
                    updateDisplay("Player X wins")
                    break
                }
                else{
                    updateDisplay("Player 0 wins")
                    break
                }

            }
            else if(boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i]){
                if(boardStatus[0][i] == 1){
                    updateDisplay("Player X wins")
                    break
                }
                else{
                    updateDisplay("Player 0 wins")
                    break
                }
            }
            else if(boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]){
                if(boardStatus[0][0] == 1){
                    updateDisplay("Player X wins")
                    break
                }
                else{
                    updateDisplay("Player 0 wins")
                    break
                }

            }
            else if(boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0]){
                if(boardStatus[0][2] == 1){
                    updateDisplay("Player X wins")
                    break
                }
                else{
                    updateDisplay("Player 0 wins")
                    break
                }

            }

        }
    }

    private fun updateDisplay(s: String) {
        t.text = s
        if(s.contains("Winner")){

            disableButton()

            }
    }

    private fun disableButton(){
        for(i in board){
            for(butt in i){
                butt.isEnabled = false

            }
        }

    }

    override fun onClick(view: View){
        when(view.id){

            R.id.button1 ->{
                updateValue(row = 0,col = 0,player = PLAYER)

            }
            R.id.button2 ->{
                updateValue(row = 0,col = 1,player = PLAYER)

            }
            R.id.button3 ->{
                updateValue(row = 0,col = 2,player = PLAYER)

            }
            R.id.button4 ->{
                updateValue(row = 1,col = 0,player = PLAYER)

            }
            R.id.button5 ->{
                updateValue(row = 1,col = 1,player = PLAYER)

            }
            R.id.button6 ->{
                updateValue(row = 1,col = 2,player = PLAYER)

            }
            R.id.button7 ->{
                updateValue(row = 2,col = 0,player = PLAYER)

            }
            R.id.button8 ->{
                updateValue(row = 2,col = 1,player = PLAYER)

            }
            R.id.button9 ->{
                updateValue(row = 2,col = 2,player = PLAYER)

            }


        }
        PLAYER = !PLAYER
        TURN_COUNT++
        if(PLAYER){
            updateDisplay("Player X  Tunr")
        }
        else{
            updateDisplay("Player 0 Turn")
        }
        if(TURN_COUNT == 9){
            updateDisplay("Game Draw")
        }
        checkWinner()
    }

    private fun updateValue(row: Int, col: Int, player: Boolean) {
        val text = if(player)"X" else "0"
        val value = if(player) 1 else 0
        board[row][col].apply{

            isEnabled = false
            setText(text)
            boardStatus[row][col] = value


        }

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (PLAYER) 1 else 0)
        parcel.writeInt(TURN_COUNT)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }


}

