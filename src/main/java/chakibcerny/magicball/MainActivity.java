package chakibcerny.magicball;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private magicAnswer ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ma = new magicAnswer();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setShapeByResourceId(R.drawable.red_oval);
        ShapeDrawable ball = new ShapeDrawable(new OvalShape());
        ball.setIntrinsicHeight(750);
        ball.setIntrinsicWidth(750);

        Paint p = ball.getPaint();
        RadialGradient radGrad = new RadialGradient(1000, 750, 300,
                Color.BLACK, Color.GRAY, Shader.TileMode.MIRROR);
        p.setShader(radGrad );
        setShapeByDrawable(ball);
    }

    public void startBall (View v){
        TextView answer = (TextView) findViewById(R.id.answer);
        EditText ques = (EditText) findViewById(R.id.question);
        TextView stion = (TextView) findViewById(R.id.ask);

        if ( ques.getText( ).toString().length( ) == 0 ) {
            Toast.makeText(this, R.string.empty_question, Toast.LENGTH_LONG).show();
        }
        else {
            stion.setText(ques.getText().toString());
            ques.getText().clear();
            startTranslate(v);
            startScale(v);
            answer.setTextSize(16);
            answer.setText(ma.newPhrase());
        }
    }

    private void setShapeByDrawable(Drawable drawable) {
        // We will animate the imageview
        ImageView reusableImageView = (ImageView) findViewById(R.id.ballView);
        reusableImageView.setImageDrawable(drawable);
    }

    public void startTranslate( View v ) {

        performAnimation(R.anim.translate_position);
    }

    public void startScale( View v ) {

        performAnimationText(R.anim.fade_out_in);
    }

    private void performAnimation(int animationResourceID) {

        Animation an = AnimationUtils.loadAnimation(this, animationResourceID);
        an.setAnimationListener(new TweenAnimationListener());
        ImageView item = (ImageView) findViewById(R.id.ballView);
        item.startAnimation(an);

    }

    private void performAnimationText(int animationResourceID) {

        Animation an = AnimationUtils.loadAnimation(this, animationResourceID);
        an.setAnimationListener(new TweenAnimationListener());
        TextView item = (TextView) findViewById(R.id.answer);
        item.startAnimation(an);

    }

    class TweenAnimationListener implements Animation.AnimationListener {

        public void onAnimationStart(Animation animation) {
            // Disable all buttons while animation is running
            enableButtons(false);
        }
        public void onAnimationEnd(Animation animation) {
            // Enable all buttons once animation is over
            enableButtons(true);
        }

        public void onAnimationRepeat(Animation animation) {
            // what to do when animation loops
        }

        // part of listener class
        private void enableButtons(boolean enabledState) {
            // Fade-out, fade-in
            final Button fadeButton = (Button) findViewById(R.id.Start);
            fadeButton.setEnabled(enabledState);

        }

    }
}
