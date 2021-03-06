package com.maga.ou.util;

import android.content.Context;
import android.text.InputFilter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.maga.ou.R;

import java.util.List;

/**
 * Created by rbseshad on 07-Jul-16.
 */
public class UIUtil
{
   public static final String NEW_LINE = System.getProperty("line.separator");

   private UIUtil ()
   {

   }

   public static final String LOG_HR = "____________________________________________________________________________________________________";

   public static final OUCurrencyHandler OU_CURRENCY_HANDLER = new OUCurrencyHandler();

   public static void setAppBarTitle (AppCompatActivity activity, int stringId, Object... arg)
   {
      if (activity.getSupportActionBar() != null)
         activity.getSupportActionBar().setTitle(UIUtil.getResourceString(activity, stringId, arg));
   }

   public static boolean[] convertIndexListToCheckedItem (List<Integer> listIndex, int itemCount)
   {
      boolean checked[] = new boolean[itemCount];
      for (int index : listIndex)
         checked[index] = true;
      return checked;
   }

   public static void setSpinnerList (Context context, Spinner combo, List<String> list)
   {
      ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, list);
      adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      combo.setAdapter(adapter);
   }

   public static void setTextCurrencyHandler (EditText editText)
   {
      editText.setText("0.00");
      editText.setFilters(new InputFilter[]{OU_CURRENCY_HANDLER});
      editText.setOnFocusChangeListener(OU_CURRENCY_HANDLER);
   }

   public static void doToastSaveSuccess (Context context)
   {
      Toast.makeText(context, getResourceString(context, R.string.toast_save_success), Toast.LENGTH_SHORT).show();
   }

   public static void doToastSaveFailure (Context context)
   {
      Toast.makeText(context, getResourceString(context, R.string.toast_save_failure), Toast.LENGTH_SHORT).show();
   }

   public static void doToastSuccess (Context context, int stringId, Object... arg)
   {
      Toast.makeText(context, getResourceString(context, stringId, arg), Toast.LENGTH_SHORT).show();
   }

   public static void doToastError (Context context, int stringId, Object... arg)
   {
      Toast.makeText(context, getResourceString(context, stringId, arg), Toast.LENGTH_SHORT).show();
   }

   public static String getResourceString (Context context, int id, Object... arg)
   {
      return context.getResources().getString(id, arg);
   }

   public static void sleep (int sec)
   {
      try
      {
         Thread.sleep(sec * 1000);
      }
      catch (InterruptedException e)
      {
         e.printStackTrace();
      }
   }
}
