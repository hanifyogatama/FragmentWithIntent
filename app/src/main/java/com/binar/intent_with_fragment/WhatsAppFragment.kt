package com.binar.intent_with_fragment

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.hbb20.CountryCodePicker
import kotlinx.android.synthetic.main.fragment_whats_app.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WhatsAppFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WhatsAppFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_whats_app, container, false)
    }

    // send message to WA
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //whatssApp
        var send = btnNextWhatsapp
        var textNumber = etWhatsappNumber
        var textMessage = etWhatsappMessage
        var countryCode = countryCodePicker as CountryCodePicker
        var messageContent: String = ""
        var phoneNumber = ""


        send.findViewById(R.id.btnNextWhatsapp) as Button
        textNumber.findViewById(R.id.etWhatsappNumber) as TextView
        textMessage.findViewById(R.id.etWhatsappMessage) as TextView
        countryCode.findViewById(R.id.countryCodePicker) as CountryCodePicker

        btnNextWhatsapp.setOnClickListener {
            phoneNumber = textNumber.text.toString()
            messageContent = textMessage.text.toString()

            if (textMessage.text.toString().isEmpty() && textNumber.text.toString()
                    .isEmpty()
            ) {
                Toast.makeText(
                    context,
                    "Enter phone number and message you want to send",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                countryCode.registerCarrierNumberEditText(textNumber)
                phoneNumber = countryCode.fullNumber
                val installed = appInstalledOrNot("com.whatsapp")

                if (installed) {
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse(
                            "https://api.whatsapp.com/send?phone=" + phoneNumber
                                    + "&text=" + messageContent
                        )
                    }
                    startActivity(intent)
                    textNumber.setText("")
                    textMessage.setText("")
                } else {
                    Toast.makeText(
                        context,
                        "WhatsApp not installed on your Device",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun appInstalledOrNot(uri: String): Boolean {
        val packageManager = context!!.packageManager
        val appInstaled: Boolean
        appInstaled = try {
            packageManager.getPackageInfo(uri, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
        return appInstaled
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WhatsAppFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WhatsAppFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}