package limited.it.planet.traintimingapp.utill;

import android.content.Context;
import android.graphics.Typeface;
public class FontCustomization {
    public Typeface TexgyreHerosRegular;
    public Typeface TexgyreHerosBold;
    Context context;

    public FontCustomization(Context mContext){
        this.context = mContext;
        this.TexgyreHerosRegular = Typeface.createFromAsset(context.getAssets(),"texgyreheros-regular.otf") ;
        this.TexgyreHerosBold = Typeface.createFromAsset(context.getAssets(),"texgyreheros-bold.otf") ;

    }
    public Typeface getTexgyreHerosRegular(){
        return TexgyreHerosRegular;
    }
    public Typeface getTexgyreHerosBold(){
        return TexgyreHerosBold;
    }
} 

