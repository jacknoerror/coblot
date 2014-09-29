package com.bocclottery.ui.settings;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.sax.StartElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bocclottery.R;
import com.bocclottery.ui.JackWindowTitleManager;
import com.bocclottery.ui.JackWindowTitleManager.JackTitleConst;

public class FAQActivity extends Activity {
	
	private static final int ANIMATION_DURATION = 199;
	private JackWindowTitleManager jwtMana;
	protected List<Faq> beautyList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_faq);
		jwtMana = new JackWindowTitleManager(this);
		jwtMana.initBackBtn();
		jwtMana.setComponent(JackTitleConst.CUSTOMTITLE_ID_MIDTEXT, getString(R.string.title_faq));
		jwtMana.setComponent(JackTitleConst.CUSTOMTITLE_ID_RIGHT1, false);
		jwtMana.setComponent(JackTitleConst.CUSTOMTITLE_ID_RIGHT2, false);
		jwtMana.initBackBtn();
		
		try{
			beautyList = new LinkedList<FAQActivity.Faq>();
			AssetManager am = getAssets();
			InputStream inputStream = am.open("faq.xml");;
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			XMLReader reader = parser.getXMLReader();
			reader.setContentHandler(getRootElement().getContentHandler());
			InputSource input = new InputSource(inputStream);
			input.setEncoding("utf-8");
			reader.parse(input);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		LinearLayout scrollContainer = (LinearLayout) findViewById(R.id.scrollcontainer_faq);
		LayoutInflater mInflater = LayoutInflater.from(this);
		if(null==beautyList) return;//error
		for(int i=0;i<beautyList.size();i++){
			LinearLayout titleAndDetailLayout = (LinearLayout) mInflater.inflate(R.layout.compound_faq, null);
			titleAndDetailLayout.setPadding(0, 1, 0, 1);
			//title
			View tView = titleAndDetailLayout.findViewById(R.id.layout_faq_title);//mInflater.inflate(R.layout.layout_linkbar, null);
			TextView barTitle = (TextView) tView.findViewById(R.id.tv_linkbar);
			final ImageView barArrow = (ImageView) tView.findViewById(R.id.img_linkbar);
			barTitle.setText(beautyList.get(i).ff);
			//detail
			final TextView tDet = (TextView) titleAndDetailLayout.findViewById(R.id.tv_faq_detail);
			tDet.setText(beautyList.get(i).qq);
			tDet.setVisibility(View.GONE);
			//animation
			final Animation animation1 = new RotateAnimation(90,-90,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
			animation1.setDuration(ANIMATION_DURATION);
			animation1.setFillAfter(true);
			barArrow.setAnimation(animation1 );
			final Animation animation2 = new RotateAnimation(-90,90,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
			animation2.setDuration(ANIMATION_DURATION);
			animation2.setFillAfter(true);
			barArrow.setAnimation(animation2 );
			//clicklistener
			tView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
//					Drawable arrowDrawable = barArrow.getDrawable();
					if(tDet.getVisibility()!=View.VISIBLE){
						barArrow.startAnimation(animation1);
						tDet.setVisibility(View.VISIBLE);
					}else {
						barArrow.startAnimation(animation2);
						tDet.setVisibility(View.GONE);
						
					}
					
				}
			});
			
			scrollContainer.addView(titleAndDetailLayout);
		}
		
	}
	/**
     * 
     * @return 返回设置好处理机制的rootElement
     */
    private RootElement getRootElement(){
//    	final Faq faq = new Faq();
    	
        /*rootElement代表着根节点，参数为根节点的tagName*/
        RootElement rootElement = new RootElement("faqs");
        /*获取一类子节点，并为其设置相应的事件
         * 这里需要注意，虽然我们只设置了一次beauty的事件，但是我们文档中根节点下的所有
         * beauty却都可以触发这个事件。
         * */
        Element beautyElement = rootElement.getChild("faq");
        // 读到元素开始位置时触发，如读到<beauty>时
        beautyElement.setStartElementListener(new StartElementListener() {
			@Override
			public void start(Attributes attributes) {
//				Log.i("通知", "start");
				Faq faq = new Faq();
				beautyList.add(faq);
			}
		});
        //读到元素结束位置时触发，如读到</beauty>时
        beautyElement.setEndElementListener(new EndElementListener() {

			@Override
			public void end() {
			}
		});
        
        Element nameElement = beautyElement.getChild("f");
        // 读到文本的末尾时触发,这里的body即为文本的内容部分
        nameElement.setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				((LinkedList<Faq>)beautyList).getLast().ff=body;
			}
		});
        
        Element ageElement = beautyElement.getChild("q");
        ageElement.setEndTextElementListener(new EndTextElementListener() {
			@Override
			public void end(String body) {
				((LinkedList<Faq>)beautyList).getLast().qq = body;
			}
		});
        return rootElement;
    	
    }
    
    
    class Faq{
    	String ff;
    	String qq;
		public Faq() {
			super();
			ff="";
			qq="";
		}
    	
    	
    }
}
