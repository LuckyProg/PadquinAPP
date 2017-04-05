package mx.ipn.padaquinproject;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.View.OnClickListener;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class Inicio extends Activity implements OnClickListener{
	
	ImageView men;
	Intent intent;
	Paint pincel = new Paint();
	Paint pincel2 = new Paint();
	Paint pincel3 = new Paint();
	Paint pincel4 = new Paint();
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.inicio);
        men = (ImageView)findViewById(R.id.men);
        men.setOnClickListener(this);
        SurfaceView surface = (SurfaceView) findViewById(R.id.surface);
        surface.getHolder().addCallback(new Callback() {

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                // Do some drawing when surface is ready
                Canvas canvas = holder.lockCanvas();
                pincel.setColor(Color.parseColor("#f0f0f0"));
                pincel.setStrokeWidth(2);
                pincel.setStyle(Style.FILL_AND_STROKE);
                pincel2.setColor(Color.argb(150, 155, 155, 155));
                pincel2.setStrokeWidth(2);
                pincel2.setStyle(Style.FILL_AND_STROKE);
                pincel3.setColor(Color.parseColor("#b2ff59"));
                pincel3.setStrokeWidth(4);
                pincel3.setStyle(Style.FILL_AND_STROKE);
                pincel4.setColor(Color.argb(80, 25, 118, 210));
                pincel4.setStrokeWidth(2);
                pincel4.setStyle(Style.FILL_AND_STROKE);
                canvas.drawLine(80, 20, 80, canvas.getHeight()-20, pincel);
                canvas.drawLine(20, canvas.getHeight()-80, canvas.getWidth()-20, canvas.getHeight()-80, pincel);
                canvas.drawLine(80, 20, 70, 60, pincel);
                canvas.drawLine(80, 20, 90, 60, pincel);
                canvas.drawLine(canvas.getWidth()-20, canvas.getHeight()-80, canvas.getWidth()-60, canvas.getHeight()-70, pincel);
                canvas.drawLine(canvas.getWidth()-20, canvas.getHeight()-80, canvas.getWidth()-60, canvas.getHeight()-90, pincel);
                int y = (canvas.getHeight()-140)/18;
                int x = (canvas.getWidth()-140)/18;
                int yant = canvas.getHeight()-80;
                int xant = 80;
                int cont = 1;
                Random r = new Random();
                int ra;
                for(int j = canvas.getHeight()-80;j>=60+(2*y);){
                	j = j-y;
                	canvas.drawLine(70, j, 90, j, pincel);
                	canvas.drawText(String.valueOf(cont), 50, j, pincel);
                	cont++;
                }
                cont = 1;
                for(int i = 80;i<=canvas.getWidth()-60-(x*2);){
                    ra = r.nextInt(18 - 1) + 1;
                	i = i+x;
                	canvas.drawLine(i, canvas.getHeight()-70, i, canvas.getHeight()-90, pincel);
                	canvas.drawText(String.valueOf(cont), i, canvas.getHeight()-50, pincel);
                	cont++;
                	/*//Rec no 1
                	canvas.drawRect(i-(x/2), canvas.getHeight()-80-(y*ra), i+(x/2), canvas.getHeight()-80, pincel4);
                	canvas.drawLine(i-(x/2), canvas.getHeight()-80, i-(x/2), canvas.getHeight()-80-(y*ra), pincel3);
                	canvas.drawLine(i+(x/2), canvas.getHeight()-80, i+(x/2), canvas.getHeight()-80-(y*ra), pincel3);
                	canvas.drawLine(i-(x/2), canvas.getHeight()-80, i+(x/2), canvas.getHeight()-80, pincel3);
                	canvas.drawLine(i-(x/2), canvas.getHeight()-80-(y*ra), i+(x/2), canvas.getHeight()-80-(y*ra), pincel3);
                	//Rec jugador
                	ra = r.nextInt(18 - 1) + 1;*/
                	canvas.drawRect(i-(x/2), canvas.getHeight()-80-(y*ra), i+(x/2), canvas.getHeight()-80, pincel2);
                	canvas.drawLine(i-(x/2), canvas.getHeight()-80, i-(x/2), canvas.getHeight()-80-(y*ra), pincel);
                	canvas.drawLine(i+(x/2), canvas.getHeight()-80, i+(x/2), canvas.getHeight()-80-(y*ra), pincel);
                	canvas.drawLine(i-(x/2), canvas.getHeight()-80, i+(x/2), canvas.getHeight()-80, pincel);
                	canvas.drawLine(i-(x/2), canvas.getHeight()-80-(y*ra), i+(x/2), canvas.getHeight()-80-(y*ra), pincel);
                	//Histograma
                	canvas.drawLine(xant, yant, i, canvas.getHeight()-80-(y*ra), pincel3);
                	xant = i;
                	yant = canvas.getHeight()-80-(y*ra);
                }
                canvas.drawLine(xant, yant, canvas.getWidth()-60, canvas.getHeight()-80, pincel3);
                holder.unlockCanvasAndPost(canvas);
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }
        });

    }
	
	private void verMenu(){
    	
    	intent = new Intent(this, Menu.class);
    	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NO_ANIMATION);
    	this.startActivity(intent);
    	overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
    
	
	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch(id){
			case R.id.men:
				verMenu();
			break;
		}
	}

}
