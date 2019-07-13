package com.example.james4;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
//import android.widget.Toolbar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;


public class home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


/*
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarToggle;
    private String mActivityTitle;
    private String[] items;

    private ExpandableListView mExpandableListView;
    private customeExpandableListAdapter adapter;

    private List<String> listTitle;
    private Map<String, List<String>> lstChild;
    private navigation_manager navignManager;

*/
//private Toolbar tool_bar;
private DrawerLayout drawer_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //init view
        Toolbar  tool_bar=findViewById(R.id.toolbar_menu);
        setSupportActionBar(tool_bar);
        drawer_layout=findViewById(R.id.drw_layout);
        NavigationView nav=findViewById(R.id.nav_view);
        nav.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this ,drawer_layout,tool_bar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();
if (savedInstanceState==null){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_farmers()).commit();
        nav.setCheckedItem(R.id.menu_farm_produce);}
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
switch (menuItem.getItemId()){
    case R.id.menu_farm_produce:
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_farmers()).commit();
        break;

    case R.id.menu_livestock_produce:
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_livestock()).commit();
        break;

    case R.id.menu_bees_keeping:
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_bees()).commit();
        break;

    case R.id.nav_share:
        Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        break;

    case R.id.nav_send:
        Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
        break;
}
drawer_layout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
public void onBackPressed(){
        if (drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START);
        }else{


        super.onBackPressed();

}}

}


/*
        mDrawerLayout =findViewById(R.id.drw_layout);
        mActivityTitle = getTitle().toString();
        mExpandableListView =findViewById(R.id.navList);


        navignManager = fragment_navigation_manager.getInstance(this);

        initItems();
        View listHeaderView = getLayoutInflater().inflate(R.layout.navigation_header, null, false);
        mExpandableListView.addHeaderView(listHeaderView);

        genData();
        addDrawersItem();
        setUpDrawer();
        if (savedInstanceState == null)
            selectFirstItemAsDefault();
getSupportActionBar().setDisplayHomeAsUpEnabled(true);
getSupportActionBar().setHomeButtonEnabled(true);
getSupportActionBar().setTitle("Mavuno");
    }

    private void selectFirstItemAsDefault() {
       if (navignManager != null){
String fistItem=listTitle.get(0);
navignManager.showFragment(fistItem);
getSupportActionBar().setTitle(fistItem);
    }}

    private void setUpDrawer() {
        mActionBarToggle=new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close)
        {
            @Override
public  void onDrawerOpened(View drawerView){
                super.onDrawerOpened(drawerView);
getSupportActionBar().setTitle("Mavuno");
invalidateOptionsMenu();
            }
            @Override
            public  void onDrawerClosed(View drawerView){
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu();
            }

        };
mActionBarToggle.setDrawerIndicatorEnabled(true);
mDrawerLayout.setDrawerListener(mActionBarToggle);

    }

    private void addDrawersItem() {
adapter=new customeExpandableListAdapter(this,listTitle, lstChild);
mExpandableListView.setAdapter(adapter);
mExpandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
    @Override
    public void onGroupExpand(int groupPosition) {
        getSupportActionBar().setTitle(listTitle.get(groupPosition).toString());//set Title for ToolBar when open menu
    }
});
mExpandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
    @Override
    public void onGroupCollapse(int groupPosition) {
        getSupportActionBar().setTitle("Mavuno");

    }
});
mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        String selectedItem=((List)(lstChild.get(listTitle.get(groupPosition)))).get(childPosition).toString();
getSupportActionBar().setTitle(selectedItem);
if(items[0].equals(listTitle.get(groupPosition)))

    navignManager.showFragment(selectedItem);

else
    throw new IllegalArgumentException("Not Supported fragment");

mDrawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
});

    }


    private void genData() {
        List<String> title = Arrays.asList("Android Programming", "Xamaring Programming", "IOS Programming");
        List<String> chiledItem = Arrays.asList("Beginer", "Advanced", "Intermediate", "Professional");

        lstChild = new TreeMap<>();
        lstChild.put(title.get(0), chiledItem);
        lstChild.put(title.get(1), chiledItem);
        lstChild.put(title.get(2), chiledItem);
        lstChild.put(title.get(3), chiledItem);
        listTitle = new ArrayList<>(lstChild.keySet());

    }


    private void initItems() {
        items = new String[]{"Android Programming", "Xamaring Programming", "IOS Programming"};

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
return true;
    }

}

    /*    farm_produce = findViewById(R.id.button_farm_produce);
        livestock_produce = findViewById(R.id.button_livestock_produce);

        livestock_produce.setOnClickListener(new View.OnClickListener(){
        @Override
            public void onClick(View view){
            if (view.getId()==R.id.button_livestock_produce){

                Intent livestock=new Intent(home.this, com.example.james4.livestock_produce.class);
                startActivity(livestock);
            }

        }

                                             }

        );

        farm_produce.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                if(v.getId()==R.id.button_farm_produce){
                    Intent i = new Intent( home.this, com.example.james4.farm_produce.class);
                    startActivity(i);

            }


        }

    });

}}
*/