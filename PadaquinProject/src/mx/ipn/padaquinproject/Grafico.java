package mx.ipn.padaquinproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;

public class Grafico extends View {
	
	Drawable draw;
	
	public Grafico(Context context) {
		
		super(context);
		draw = context.getResources().getDrawable(R.drawable.usua);

	}
	@Override
	protected void onDraw(Canvas canvas){
		//Aqui_vamos_a_dibujar
		//canvas.drawColor(Color.parseColor("#ffe6b3"));
		Paint pincel = new Paint();
		pincel.setColor(Color.BLACK);
		pincel.setStrokeWidth(1);
		pincel.setTextSize(45);
		pincel.setTextSkewX(-1);
		pincel.setStyle(Style.FILL_AND_STROKE);
		draw.setBounds((canvas.getWidth()/2)-(canvas.getWidth()/8), 150, (canvas.getWidth()/2)+(canvas.getWidth()/8), (canvas.getWidth()/4)+150);
		draw.draw(canvas);
	}

}
