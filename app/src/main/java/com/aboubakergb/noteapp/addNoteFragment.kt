package com.aboubakergb.noteapp

import android.content.ContentValues
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_add_note.*


class addNoteFragment : Fragment(R.layout.fragment_add_note) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        btn_add.setOnClickListener {
            addNotesEvent()
        }
    }
    // fun add notes
    private fun addNotesEvent() {
        val title = et_add_title.text.toString()
        val description = et_add_note.text.toString()


        val values = ContentValues()
        values.put("Title", title)
        values.put("Description", description)

        val dbManager = DbManager(this.requireActivity())
        val id = dbManager.insertNote(values)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.addnote_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item!!.itemId){
            R.id.mi_back->{
                view?.findNavController()?.navigate(R.id.notesListFragment)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    }