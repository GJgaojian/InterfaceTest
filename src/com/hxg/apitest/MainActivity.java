package com.hxg.apitest;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.hxg.apitest.adater.MyAdapter;
import com.hxg.apitest.adater.MyAdapter2;
import com.hxg.apitest.entity.APIEntity;
import com.hxg.apitest.util.XmlUtil;

public class MainActivity extends ActionBarActivity {

	Context context;
	ListView listView;
	MyAdapter2 myAdapter;
	List<APIEntity> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;

		Intent intent = getIntent();
		path = intent.getStringExtra("path");
		init();
	}

	private String strr;
	private String path;

	private void init() {
//		final String str = "name=bbbbb123j&pwd=123";
		// new Thread(){
		//
		// public void run() {
		// strr =
		// PostUtil.sendPostAndGetInfo("http://www.yasite.net/shopapi/index.php/userController/register",str,"POST");
		// System.out.println(strr);
		// };
		// }.start();

		try {
			FileInputStream fos = new FileInputStream(new File(path));
//			String josn = StreamUtil.stream2String(fos);
//			APIListEntity apiListEntity = JsonUtil.parse2Json(josn);
//			list = apiListEntity.getList();
			list = XmlUtil.parseXml(fos);
			for (APIEntity a : list) {
				System.out.println(a);
			}
			
			listView = (ListView) findViewById(R.id.listView);
			myAdapter = new MyAdapter2(context, list);
			listView.setAdapter(myAdapter);
			
			for (APIEntity a : list) {
//				testApi(a);
				myAdapter.notifyDataSetChanged();
//				Thread.sleep(2000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	private void testApi(final APIEntity apiEntity) {
//		new Thread() {
//			public void run() {
//				if (apiEntity.getMethod().equalsIgnoreCase("post")) {
//					System.out.println("`````post");
//					strr = PostUtil.sendPostAndGetInfo(apiEntity.getUrl(),
//							apiEntity.getParams());
//				} else {
//					System.out.println("``````get");
//					strr = GetUtil.sendRequest(apiEntity.getUrl(),
//							apiEntity.getParams());
//				}
//				if(strr != null){
//					apiEntity.setFlag(true);
//					apiEntity.setResult(strr);
//					System.out.println(strr);
//				}else{
//					apiEntity.setResult("empty");
//				}
//			};
//		}.start();
//	}

}
