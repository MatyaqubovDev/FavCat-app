package dev.matyaqubov.favcats.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import dev.matyaqubov.favcats.R

class AddPhotoFragment : Fragment() {

    private lateinit var b_upload:Button
    lateinit var imageView: ImageView
    lateinit var tv_isSelected:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return initViews(inflater.inflate(R.layout.fragment_add_photo, container, false))
    }

    private fun initViews(view: View): View{
        b_upload=view.findViewById(R.id.b_upload)
        imageView=view.findViewById(R.id.image)
        tv_isSelected=view.findViewById(R.id.tv_isSelect)
        b_upload.setOnClickListener {
//upload
            activity?.onBackPressed()
        }
        return view
    }

}