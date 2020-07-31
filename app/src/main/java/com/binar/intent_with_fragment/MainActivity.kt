package com.binar.intent_with_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var bundleFragment: BundleFragment
    lateinit var serializableFragment: SerializableFragment
    lateinit var parcelableFragment: ParcelableFragment
    lateinit var dialFragment: DialFragment
    lateinit var whatsAppFragment: WhatsAppFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {}

        // default fragment
        bundleFragment = BundleFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, bundleFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        // bottomNavigation.inflateMenu(R.menu.bottom_nav)

        bottomNavigation.setOnNavigationItemSelectedListener { item: MenuItem ->
            return@setOnNavigationItemSelectedListener when (item.itemId) {
                // Bundle fragment
                R.id.itemNavigationBundle -> {
                    bundleFragment = BundleFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, bundleFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    true
                }

                // serializable Fragment
                R.id.itemNavigationSerializable -> {
                    serializableFragment = SerializableFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, serializableFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    true
                }

                // parcelable Fragment
                R.id.itemNavigationParcelable -> {
                    parcelableFragment = ParcelableFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, parcelableFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    true
                }

                // dial Fragment
                R.id.itemNavigationDial -> {
                    dialFragment = DialFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, dialFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    true
                }

                // whatsApp Fragment
                R.id.itemNavigationWhatsapp -> {
                    whatsAppFragment = WhatsAppFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, whatsAppFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    true
                }

                else -> false
            }
        }
    }
}




