package wgcv.me.tuio;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wgcv on 01/09/15.
 */
public class MenuLateral {
    public Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    final  AppCompatActivity principal;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    public MenuLateral(final AppCompatActivity principal){
        this.principal = principal;
        nitView();
        if (toolbar != null) {
            toolbar.setTitle("Tuio");
            principal.setSupportActionBar(toolbar);
        }
        initDrawer();
        // get the listview
        expListView = (ExpandableListView) principal.findViewById(R.id.lvExp);
        // preparing list data
        prepareListData();
        listAdapter = new ExpandableListAdapter(principal, listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);

        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Log.d("skt", "clicked parent " + groupPosition + " child "
                        + id);
                if(groupPosition == 0){
                    Intent intent = new Intent(principal, Principal.class);
                    principal.startActivity(intent);


                }
                if(groupPosition == 5){
                    Intent intent = new Intent(principal, Principal.class);
                    principal.startActivity(intent);
                }
                return false;
            }
        });
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView arg0,
                                        View arg1, int groupPosition, int childPosition, long arg4) {
                // TODO Auto-generated method stub

                Log.d("skt", "clicked parent " + groupPosition + " child "
                        + childPosition);
                //Log.d( expListView.getExpandableListAdapter().getChild(groupPosition, childPosition).toString(), "Memnsaje");
                if (groupPosition == 1){
                    if(childPosition== 0){
                        Intent intent = new Intent(principal, Principal.class);
                        principal.startActivity(intent);

                    }
                }
                if(groupPosition == 3){
                    if(childPosition== 3){
                        Intent intent = new Intent(principal, Principal.class);
                        principal.startActivity(intent);



                    }else{
                        Intent intent = new Intent(principal, Principal.class);
                        intent.putExtra("inhe?fo", expListView.getExpandableListAdapter().getChild(groupPosition, childPosition).toString());

                        principal.startActivity(intent);


                    }

                }
                if (groupPosition == 4){
                    if(childPosition== 1){
                        Intent intent = new Intent(principal, Principal.class);
                        principal.startActivity(intent);

                    }
                }
                if (groupPosition == 6){
                    if(childPosition== 0){
                        Intent intent = new Intent(principal, Principal.class);
                        principal.startActivity(intent);

                    }
                }

                return false;
            }
        });

    }

    public void syncState() {
        drawerToggle.syncState();

    }
    public void onConfigurationChanged(Configuration newConfig){
        drawerToggle.onConfigurationChanged(newConfig);

    }
    private void nitView() {
        toolbar = (Toolbar) principal.findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) principal.findViewById(R.id.drawerLayout);
    }

    private void initDrawer() {

        drawerToggle = new ActionBarDrawerToggle(principal, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
    }


    /*
   * Preparing the list data
   */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Inicio");
        listDataHeader.add("Información");
        listDataHeader.add("La comunidad");
        listDataHeader.add("Consultas");
        listDataHeader.add("Salud");
        listDataHeader.add("Puntos Wifi");
        listDataHeader.add("Información del municipio");

        // Adding child data
        List<String> informacion = new ArrayList<String>();
        informacion.add("Noticias");
        informacion.add("Agenda");


        List<String> LaComunidad = new ArrayList<String>();
        LaComunidad.add("Sitios turísticos");
        LaComunidad.add("Información");
        LaComunidad.add("Contactanos y quejas");

        List<String> consultas = new ArrayList<String>();
        consultas.add("Rentas");
        consultas.add("Matriculación");
        consultas.add("Servicios de agua");
        consultas.add("Terminal Terrestre");
        List<String> salud = new ArrayList<String>();
        salud.add("Consulta de citas");
        salud.add("Solicitar citas");
        salud.add("Puntos médicos");

        List<String> informacionMunicipio = new ArrayList<String>();
        informacionMunicipio.add("Agencia del municipio");
        informacionMunicipio.add("Números de Emergencias");

        listDataChild.put(listDataHeader.get(0), new ArrayList<String>()); // Header, Child data
        listDataChild.put(listDataHeader.get(1), informacion);
        listDataChild.put(listDataHeader.get(2), LaComunidad);
        listDataChild.put(listDataHeader.get(3), consultas);
        listDataChild.put(listDataHeader.get(4), salud);
        listDataChild.put(listDataHeader.get(5), new ArrayList<String>());
        listDataChild.put(listDataHeader.get(6), informacionMunicipio);

    }
}
